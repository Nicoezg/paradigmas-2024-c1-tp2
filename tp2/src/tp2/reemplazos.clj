(ns tp2.reemplazos
(:require [clojure.string :as str]))

(defn reemplazar [res restantes reglas]
  (if (empty? restantes)
    res
    (let [reemplazo (get reglas (first restantes) (first restantes))]
      (recur (str res reemplazo) (rest restantes) reglas))))

(defn aplicar [s reglas]
  (let [sec-strings (map str (seq s))]
    (reemplazar "" sec-strings reglas)))

(defn aplicar-reglas [axioma reglas n]
  (let [res(aplicar axioma reglas)
    contador(dec n)]
    (if (zero? contador)
      res
      (recur res reglas contador))))