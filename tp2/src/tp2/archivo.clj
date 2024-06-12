(ns tp2.archivo
(:require [clojure.java.io :as io]
          [clojure.string :as str]))

(defn leer-archivo
  "Lee un archivo y retorna su contenido"
  [nombre-archivo]
  (with-open [archivo (io/reader nombre-archivo)]
    (doall (line-seq archivo)))
)

(defn analizar-sl
  "Reciben informacion del archivo sl
  y devuelve un hashmap {predesor1:sucesor1,...,predesorN:sucesorN}"   
    [infoArchivo]
    (let [n (count infoArchivo)
          predecesores (map #(first (str/split % #" ")) (drop 2 infoArchivo))
          sucesores (map #(second (str/split % #" ")) (drop 2 infoArchivo))]
          (zipmap predecesores sucesores)

    ))






"<ángulo>
<axioma>
<predecesor1> <sucesor1>
<predecesor2> <sucesor2>
<predecesor3> <sucesor3>"