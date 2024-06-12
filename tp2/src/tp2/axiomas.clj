(ns tp2.axiomas
  (:require [clojure.string :as str]
            [tp2.tortuga :as tort]
            [tp2.pila :as pila]))

(defn girar-derecha [pila-t angulo]
  (pila/apilar (pila/desapilar pila-t) (tort/derecha (pila/ver-tope pila-t) angulo))
)

(defn girar-izquierda [pila-t angulo]
  (pila/apilar (pila/desapilar pila-t) (tort/izquierda (pila/ver-tope pila-t) angulo))
)

(defn levantar-pluma [pila-t]
  (pila/apilar (pila/desapilar pila-t) (tort/adelante (pila/ver-tope pila-t) 1))
)

(defn girar-180 [pila-t]
  (pila/apilar (pila/desapilar pila-t) (tort/derecha (pila/ver-tope pila-t) 180))
)

(defn procesar [parte-axioma pila-t tortugas angulo]
  (let [tortuga-anterior (pila/ver-tope pila-t)
        pila-c (case parte-axioma
                 "+" (girar-derecha pila-t angulo)
                 "-" (girar-izquierda pila-t angulo)
                 "[" (pila/apilar pila-t (pila/ver-tope pila-t))
                 "]" (pila/desapilar pila-t)
                 "f" (levantar-pluma pila-t)
                 "g" (levantar-pluma pila-t)
                 "|" (girar-180 pila-t)
                 nil)]
    (if pila-c
        [pila-c  tortugas ]
      (let [n (count (filter #(#{\F \G} %) parte-axioma))
            tortuga-act (tort/adelante tortuga-anterior n)
            pila-tope-actualizado (pila/apilar (pila/desapilar pila-t) tortuga-act)]
        [pila-tope-actualizado (conj tortugas [tortuga-anterior tortuga-act])]))))


(defn iterar-axiomas [lista-axiomas pila vectores angulo]
  (let [pila-y-tortuga (procesar (first lista-axiomas) pila vectores angulo)
        pila-actualizada (first pila-y-tortuga)
        tortugas-actualizadas (second pila-y-tortuga)]
    (if (empty? (rest lista-axiomas))
      tortugas-actualizadas
      (iterar-axiomas (rest lista-axiomas) pila-actualizada tortugas-actualizadas angulo))))

(defn obtener-lineas [lista-axiomas angulo]
  (let [pila-t (pila/pila (tort/tortuga))]
      (iterar-axiomas lista-axiomas pila-t [] angulo)
  )
)


