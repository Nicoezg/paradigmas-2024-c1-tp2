(ns tp2.vector2d)

(defn vec2d [x y] {:x x :y y})

(defn vec2d-x [v] (v :x))
(defn vec2d-y [v] (v :y))

(defn vec2d-set-x [v new-x] (assoc v :x new-x))

(defn vec2d-set-y [v new-y] (assoc v :y new-y))

(defn vec2d+ [a b](vec2d
                    (+ (vec2d-x a) (vec2d-x b))
                    (+ (vec2d-y a) (vec2d-y b))
))