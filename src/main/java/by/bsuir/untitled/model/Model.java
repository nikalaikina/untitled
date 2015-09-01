package by.bsuir.untitled.model;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class Model {

    private Set<Ray> rays = new HashSet<>();
    private List<Segment> segments = new ArrayList<>();
    private Set<Point> staticPoints = new HashSet<>();

    public Model() {
        rays.add(new Ray(new Point(12, 24), 5.9));
        inc(100);
    }

    public void startRay(Ray ray) {
        if (ray.getLength() == 0) {
            rays.add(ray);
        }
    }

    private void inc(final int delta) {
        rays.stream().forEach(r -> r.lengthen(delta));
        resolve();
    }

    public void inc() {
        rays.stream().forEach(Ray::lengthen);
        resolve();
    }

    private void resolve() {
        Set<Point> ends = rays
                .stream()
                .map(Ray::getEnd)
                .collect(Collectors.toSet());

        // Set<Point> pointspoints.addAll(staticPoints);

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
