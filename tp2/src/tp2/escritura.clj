(ns tp2.escritura
  (:require [clojure.string :as str]
   [clojure.java.io :as io] [tp2.tortuga :as tort]
   [tp2.pila :as pila]))

(defn primer-linea
  "Escribe el encabezado del arhcivo .svg."
  [x-min y-min x-max y-max nombre-archivo]
  (spit nombre-archivo (str "<svg viewBox=\""  (- x-min 50) " " (- y-min 50) " " 
  (+ x-max 100 (Math/abs x-min) ) " " (+ y-max (Math/abs y-min) 100) "\" xmlns=\"http://www.w3.org/2000/svg\">\n")))

(defn lineas
  "Escribe las líneas que codifican las trazas en el archivo SVG."
  [linea-tortugas nombre-archivo]
  (if (empty? linea-tortugas)
      (spit nombre-archivo "</svg>" :append true)
      (let [par-vector (first linea-tortugas)
          primer-tortuga (first par-vector)
          segunda-tortuga (second par-vector)
          primer-tortuga-x (tort/tortuga-x primer-tortuga)
          primer-tortuga-y (tort/tortuga-y primer-tortuga)
          segunda-tortuga-x (tort/tortuga-x segunda-tortuga)
          segunda-tortuga-y (tort/tortuga-y segunda-tortuga)
          linea-svg (str "  <line x1=\"" primer-tortuga-x "\" y1=\"" primer-tortuga-y "\" x2=\"" 
          segunda-tortuga-x "\" y2=\"" segunda-tortuga-y "\" stroke-width=\"1\" stroke=\"black\" />\n")
          resto-lineas (rest linea-tortugas)]
          
          (if (tort/misma-posicion? primer-tortuga segunda-tortuga)
              (lineas resto-lineas nombre-archivo)
              (do
                  (spit nombre-archivo linea-svg :append true)
                  (recur resto-lineas nombre-archivo))))))