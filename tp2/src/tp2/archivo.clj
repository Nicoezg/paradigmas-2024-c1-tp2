(ns tp2.archivo
(:require [clojure.java.io :as io]))

(defn leer-archivo
  "Lee un archivo y retorna su contenido"
  [nombre-archivo]
  (with-open [archivo (io/reader nombre-archivo)]
    (doall (line-seq archivo)))
)







"<ángulo>
<axioma>
<predecesor1> <sucesor1>
<predecesor2> <sucesor2>
<predecesor3> <sucesor3>"