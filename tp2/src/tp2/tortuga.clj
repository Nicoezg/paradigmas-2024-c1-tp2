(ns tp2.tortuga
(:require [tp2.vector2d :as vec]))

(defn tortuga [] {:posicion (vec/vec2d 0 0) :orientacion 270})

(defn adelante [tortuga n]
  (let [pos (get tortuga :posicion)
      orient (get tortuga :orientacion)
      movx (vec/vec2d-set-x pos (+ (vec/vec2d-x pos) (* n 10 (Math/cos (/ (* Math/PI orient) 180 )))))
      movcompleto (vec/vec2d-set-y movx (+ (vec/vec2d-y movx) (* n 10 (Math/sin (/ (* Math/PI orient) 180)))))]
      (assoc tortuga :posicion movcompleto)))

(defn derecha [tortuga new-angulo]
  (let [angulo (- (get tortuga :orientacion) new-angulo)]
      (if (< angulo 0) 
          (assoc tortuga :orientacion (+ angulo 360))
          (assoc tortuga :orientacion angulo))))

(defn izquierda [tortuga new-angulo]
  (let [angulo (+ (get tortuga :orientacion) new-angulo)]
      (if (>= angulo 360)
          (assoc tortuga :orientacion (- angulo 360))
          (assoc tortuga :orientacion angulo))))

(defn tortuga-x [tortuga] (vec/vec2d-x(get tortuga :posicion)))

(defn tortuga-y [tortuga] (vec/vec2d-y(get tortuga :posicion)))

(defn tortuga-orientacion [tortuga] (get tortuga :orientacion))

(defn tortuga-set-posicion [tortuga x y]
    (let [posx (vec/vec2d-set-x (get tortuga :posicion) x)
        posfinal (vec/vec2d-set-y posx y)]
        (assoc tortuga :posicion posfinal)))

(defn max-x
  "Encuentra el máximo valor de la coordenada x entre todas las tortugas en una lista de listas de dos tortugas cada una.
      lista-tortugas: lista de listas de dos tortugas cada una."
  [lista-tortugas]
  (apply max (map #(max (tortuga-x (first %)) (tortuga-x (second %))) lista-tortugas)))

(defn max-y
  "Encuentra el máximo valor de la coordenada y entre todas las tortugas en una lista de listas de dos tortugas cada una.
      lista-tortugas: lista de listas de dos tortugas cada una."
  [lista-tortugas]
  (apply max (map #(max (tortuga-y (first %)) (tortuga-y (second %))) lista-tortugas)))

(defn min-x 
    "Encuentra el mínimo valor de la coordenada x entre todas las tortugas en una lista de listas de dos tortugas cada una.
        lista-tortugas: lista de listas de dos tortugas cada una."
    [lista-tortugas]
    (apply min (map #(min (tortuga-x (first %)) (tortuga-x (second %))) lista-tortugas)))

(defn min-y 
    "Encuentra el mínimo valor de la coordenada y entre todas las tortugas en una lista de listas de dos tortugas cada una.
    lista-tortugas: lista de listas de dos tortugas cada una."

    [lista-tortugas]
    (apply min (map #(min (tortuga-y (first %)) (tortuga-y (second %))) lista-tortugas)))

(defn misma-posicion? [tortuga1 tortuga2]
  (and (= (tortuga-x tortuga1) (tortuga-x tortuga2))
       (= (tortuga-y tortuga1) (tortuga-y tortuga2))))
