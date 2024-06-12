(ns tp2.core
  (:gen-class)
  (:require [tp2.archivo :as archivo]
            [clojure.string :as str]
            [tp2.reemplazos :as reemplazos]
            [tp2.axiomas :as axiomas]
            [tp2.tortuga :as tort]
            [tp2.escritura :as escritura]))


(defn -main
  "Lee el archivo y aplica los reemplazos especificados."
  [& args]
  (let [infoArchivo (archivo/leer-archivo (nth args 0))
        angulo (Float/parseFloat (first infoArchivo))
        n-reemplazos (Integer/parseInt (nth args 1))
        axioma (second infoArchivo)
        predecesores-sucesores (archivo/analizar-sl infoArchivo)
        axioma-final (reemplazos/n-reemplazos axioma predecesores-sucesores n-reemplazos)
        axioma-spliteado (reemplazos/separar-lineas axioma-final)
        tortugas-procesadas (axiomas/obtener-lineas axioma-spliteado angulo)
        min-x (tort/min-x tortugas-procesadas)
        min-y (tort/min-y tortugas-procesadas)
        max-x (tort/max-x tortugas-procesadas)
        max-y (tort/max-y tortugas-procesadas)
        nombre-archivo (nth args 2)]
        (escritura/primer-linea min-x min-y max-x max-y nombre-archivo)
        
        (escritura/lineas tortugas-procesadas nombre-archivo)

    ))


;; tortugas-procesadas (axiomas/obtener-lineas axioma-final angulo)]
;;         min-x(tort/min-x tortugas-procesadas)
;;         min-y(tort/min-y tortugas-procesadas)
;;         max-x(tort/max-x tortugas-procesadas)
;;         max-y(tort/max-y tortugas-procesadas)
;;         (escritura/primer-linea min-x min-y max-x max-y nombre-archivo)
;;         (escritura/lineas tortugas-procesadas nombre-archivo )