package by.bsuir.untitled.model;

import by.bsuir.untitled.control.math.Calculator;
import by.bsuir.untitled.control.math.Proector;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static by.bsuir.untitled.control.math.Calculator.distance;

@Component
public class Model {

    private Set<Ray> rays = new HashSet<>();
    private List<Segment> segments = new ArrayList<>();
    private static final int e = 5;

    public void startRay(Ray ray) {
        if (ray.getLength() == 0) {
            rays.add(ray);
        }
    }

    public void inc() {
        rays.stream().filter(ray -> !ray.lengthen()).forEach(this::cutRay);
        rays.stream().forEach(this::crashed);
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
                && Calculator.distance(ray.getStart(), segment.getStart()) > e;
    }

    private void reflect(Ray ray, Segment segment) {
        cutRay(ray);
        Proector proector = new Proector(ray.getSegment(), segment);
        Point proection = proector.proect();
        if (distance(proection, ray.getEnd()) > e) {
            System.out.println("reflectin");
            double angle = Calculator.angle(ray.getSegment(), proection);
            startRay(new Ray(ray.getEnd(), angle));
        }
    }

    private void cutRay(Ray ray) {
        rays.remove(ray);
        segments.add(ray.getSegment());
    }

    public List<Segment> getModel() {
        List<Segment> model = new ArrayList<>(segments.size() + rays.size());
        model.addAll(segments);
        model.addAll(rays.stream().map(Ray::getSegment).collect(Collectors.toList()));

        return model;
    }
}
