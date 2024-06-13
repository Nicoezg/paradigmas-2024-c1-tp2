(ns tp2.reemplazos
(:require [clojure.string :as str]))



(defn replace-tail [acc restantes reglas]
  (if (empty? restantes)
    acc
    (let [reemplazo (get reglas (first restantes) (first restantes))]
      (recur (str acc reemplazo) (rest restantes) reglas))))

(defn reemplazar [s reglas]
  (let [sec-strings (map str (seq s))]
    (replace-tail "" sec-strings reglas)))

(defn iterar [axioma reglas n]
  (let [res(reemplazar axioma reglas)
        contador(dec n)]
        (if (zero? contador)
            res
            (recur res reglas contador))
  )
)

(defn reemplazar [s reglas]
  (let [sec-strings (map str (seq s))]
    (replace-tail "" sec-strings reglas)))