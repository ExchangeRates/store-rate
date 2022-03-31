package com.wcreators.storerate;

import lombok.Builder;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.Optional;

public class StoreRateApplication {

    @Builder
    static class Point {
        Point left;
        Point right;
        Double value;
    }

    public static void main(String[] args) {
        Point root = Point.builder()
                .value(5D)
                .right(Point.builder()
                        .value(7D)
                        .right(Point.builder().value(8D).build())
                        .left(Point.builder().value(6D).build())
                        .build())
                .left(Point.builder()
                        .value(3D)
                        .left(Point.builder().value(1D).build())
                        .right(Point.builder().value(4D).build())
                        .build())
                .build();
        findNext(root, 8.5);
        findNext(root, 2.5);
        findNext(root, 3.5);
        findNext(root, 4.5);
        findNext(root, 5.5);
        findNext(root, 6.5);
        findNext(root, 7.5);
        findNext(root, 0.5);
        JsonDeserializer.KEY_DEFAULT_TYPE
    }

    /**
0.5
           5
     3         7
  1     4  | 6   8
     3.5
     */

    private static void findNext(Point root, double value) {
        Optional<Double> res = findNextWithAns(root, value, Optional.empty());
        if (res.isPresent()) {
            System.out.println("FOUND " + res.get());
        } else {
            System.out.println("NOT FOUND");
        }
    }

    private static Optional<Double> findNextWithAns(Point root, double value, Optional<Double> ans) {
        if (root.value > value) {
            if (root.left == null) {
                return Optional.of(root.value);
            }
            return findNextWithAns(root.left, value, Optional.of(root.value));
        }
        if (root.right == null) {
            return ans;
        }
        return findNextWithAns(root.right, value, ans);
    }
}
