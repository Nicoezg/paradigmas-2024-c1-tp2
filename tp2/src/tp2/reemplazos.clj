(ns tp2.reemplazos
(:require [clojure.string :as str]))



(defn reemplazar [axioma reglas]
  (reduce (fn [acc [k v]] (clojure.string/replace acc k v)) axioma reglas))

(defn n-reemplazos
  "Aplica la función de reemplazo n veces."
  [axioma reglas n]
  (loop [axioma axioma
         i n]
    (if (zero? i)
      axioma
      (recur (reemplazar axioma reglas) (dec i)))))