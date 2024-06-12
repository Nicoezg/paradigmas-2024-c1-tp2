(ns tp2.tortuga
(:require [tp2.vector2d :as vec]))

(defn tortuga [] {:posicion (vec/vec2d 0 0) :orientacion 0 :pluma 1})

(defn adelante [tortuga n]
  (let [pos (get tortuga :posicion)
        orient (get tortuga :orientacion)
        movx (vec/vec2d-set-x pos (+ (vec/vec2d-x pos) (* n (Math/cos (/ (* Math/PI orient) 180 )))))
        movcompleto (vec/vec2d-set-y movx (+ (vec/vec2d-y movx) (* n (Math/sin (/ (* Math/PI orient) 180)))))]
    (assoc tortuga :posicion movcompleto)))


(defn derecha [tortuga new-angulo]
  (let [angulo (- (get tortuga :orientacion) new-angulo)]
    (if (< angulo 0) 
      (assoc tortuga :orientacion (+ angulo 360))
      (assoc tortuga :orientacion angulo))))

(defn izquierda [tortuga new-angulo]
  (let [angulo (+ (get tortuga :orientacion) new-angulo)]
    (if (> angulo 360)
      (assoc tortuga :orientacion (- angulo 360))
      (assoc tortuga :orientacion angulo))))

(defn pluma_arriba [tortuga] (assoc tortuga :pluma 0))

(defn pluma_abajo [tortuga] (assoc tortuga :pluma 1))

(defn estado-pluma [tortuga] (get tortuga :pluma))

(defn tortuga-x [tortuga] (vec/vec2d-x(get tortuga :posicion)))

(defn tortuga-y [tortuga] (vec/vec2d-y(get tortuga :posicion)))

(defn tortuga-orientacion [tortuga] (get tortuga :orientacion))

(defn tortuga-set-posicion [tortuga x y]
    (let [posx (vec/vec2d-set-x (get tortuga :posicion) x)
            posfinal (vec/vec2d-set-y posx y)]
            (assoc tortuga :posicion posfinal))
)