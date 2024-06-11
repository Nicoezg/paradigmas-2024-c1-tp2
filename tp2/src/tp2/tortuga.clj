(ns tp2.tortuga
(:require [tp2.vector2d :as vec]))

(defn tortuga [] {:posicion (vec/vec2d 0 0) :orientacion 0 :pluma 1})

(defn adelante [tortuga n] 
    (assoc tortuga :posicion (vec/vec2d-set-x (get tortuga :posicion) (+ (get tortuga :posicion) (* n (Math/cos (get tortuga :orientacion)))))))

(defn derecha [tortuga new-angulo] (
    (assoc tortuga :orientacion (- (get tortuga :orientacion) new-angulo))
))

(defn izquierda [tortuga new-angulo] (
    (assoc tortuga :orientacion (+(get tortuga :orientacion) new-angulo))
))

(defn pluma_arriba [tortuga] (assoc tortuga :pluma 0))

(defn pluma_abajo [tortuga] (assoc tortuga :pluma 1))

(defn estado-pluma [tortuga] (get tortuga :pluma))

(defn tortuga-x [tortuga] (vec/vec2d-x(get tortuga :posicion)))

(defn tortuga-y [tortuga] (vec/vec2d-y(get tortuga :posicion)))

(defn tortuga-orientacion [tortuga] (get tortuga :orientacion))