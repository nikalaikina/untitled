package by.bsuir.untitled.model;

import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static by.bsuir.untitled.control.math.Calculator.*;
import static java.util.stream.Collectors.toList;

@Component
public class Model {

    private final Set<Ray> rays = new HashSet<>();
    private final List<Segment> segments = new ArrayList<>();
    private static final int e = 5;

    public void startRay(Ray ray) {
        if (ray.getLength() == 0) {
            rays.add(ray);
        }
    }

    public void inc() {
        rays.stream()
            .filter(ray -> !ray.lengthen())
            .forEach(this::cutRay);

        rays.stream()
            .forEach(this::crashed);
    }

    private void crashed(Ray ray) {
        for (Ray otherRay : rays) {
            if (ray != otherRay && crashed(ray, otherRay.getSegment())) {
                reflect(ray, otherRay.getSegment());
                return;
            }
        }

        for (Segment segment : segments) {
            if (crashed(ray, segment)) {
                reflect(ray, segment);
                return;
            }
        }
    }

    private boolean crashed(Ray ray, Segment segment) {
        return distance(ray.getEnd(), segment) < distance(ray.getStart(), segment)
                && distance(ray.getEnd(), segment) < e
                && distance(ray.getStart(), segment.getStart()) > e;
    }

    private void reflect(Ray ray, Segment segment) {
        cutRay(ray);
        Point proection = proect(ray, segment);

        if (distance(proection, ray.getEnd()) > e) {
            System.out.println("reflectin");
            double angle = angle(ray.getSegment(), proection);
            startRay(new Ray(ray.getEnd(), angle));
        }
    }

    private void cutRay(Ray ray) {
        rays.remove(ray);
        segments.add(ray.getSegment());
    }

    public List<Segment> getModel() {
        List<Segment> model = new ArrayList<>();
        model.addAll(segments);
        model.addAll(rays.stream()
                         .map(Ray::getSegment)
                         .collect(toList()));

        return model;
    }
}
