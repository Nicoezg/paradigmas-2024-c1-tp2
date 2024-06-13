(ns tp2.axiomas
  (:require [clojure.string :as str]
            [tp2.tortuga :as tort]
            [tp2.pila :as pila]))

(defn girar-derecha [pila-t angulo]
  (pila/apilar (pila/desapilar pila-t) (tort/derecha (pila/ver-tope pila-t) angulo)))

(defn girar-izquierda [pila-t angulo]
  (pila/apilar (pila/desapilar pila-t) (tort/izquierda (pila/ver-tope pila-t) angulo)))

(defn levantar-pluma [pila-t]
  (pila/apilar (pila/desapilar pila-t) (tort/adelante (pila/ver-tope pila-t) 1)))

(defn girar-180 [pila-t]
  (pila/apilar (pila/desapilar pila-t) (tort/derecha (pila/ver-tope pila-t) 180)))

(defn procesar [caracter-axioma pila-t tortugas ini-tortuga angulo]
  "Recibe un axioma, una pila de tortugas que se va actualizando, un vector de vectores de tortugas en el cual se agregan
  tortugas de a pares, una tortuga inicial y un angulo"
  (let [tortuga-anterior (pila/ver-tope pila-t)
      pila-c (case (str caracter-axioma)
              "+" (girar-derecha pila-t angulo)
              "-" (girar-izquierda pila-t angulo)
              "[" (pila/apilar pila-t tortuga-anterior)
              "]" (pila/desapilar pila-t)
              "f" (levantar-pluma pila-t)
              "g" (levantar-pluma pila-t)
              "|" (girar-180 pila-t)
              "F" (pila/apilar (pila/desapilar pila-t) (tort/adelante tortuga-anterior 1))
              "G" (pila/apilar (pila/desapilar pila-t) (tort/adelante tortuga-anterior 1))
              nil)] ; Valor por defecto si caracter-axioma no coincide con ninguno de los casos
      (cond (nil? pila-c) 
          [pila-t tortugas ini-tortuga] ; No se encontró ningún caso válido
          (tort/misma-posicion? tortuga-anterior (pila/ver-tope pila-c))
          [pila-c (conj tortugas [ini-tortuga tortuga-anterior]) 
          (pila/ver-tope pila-c)] ; Misma posición, actualizamos las tortugas
          (= (str caracter-axioma)"]")
          [pila-c (conj tortugas [ini-tortuga tortuga-anterior]) 
          (pila/ver-tope pila-c)] 
        
          :else [pila-c tortugas ini-tortuga]))) ; Caso general, actualizamos la pila y mantenemos las tortugas y la tortuga inicial

(defn iterar-axiomas [axiomas pila vectores angulo tortuga-ini]
"Recibe una cadena de axiomas, una pila de tortugas, una lista de listas vacia, un ángulo y una tortuga inicial.
Avanza en la cadena, procesando cada acción a realizar."
  (let [pila-y-tortuga (procesar (first axiomas) pila vectores tortuga-ini angulo)
      pila-actualizada (first pila-y-tortuga)
      tortugas-actualizadas (second pila-y-tortuga)
      tortuga-ini-act (last pila-y-tortuga)]

      (if (empty? (subs axiomas 1))
          tortugas-actualizadas
          (recur (subs axiomas 1) pila-actualizada tortugas-actualizadas angulo tortuga-ini-act))))

(defn obtener-lineas [axioma angulo]
"Wrapper de la función iterar-axiomas, crea la pila y la tortuga necesaria para empezar a iterar."
  (let [pila-t (pila/pila (tort/tortuga))]
      (iterar-axiomas axioma pila-t [] angulo (tort/tortuga))))