(ns tp2.pila)

(defn pila [tortuga] (conj '() tortuga))

(defn desapilar[pila] (pop pila))

(defn apilar[pila tortuga] (conj pila tortuga))

(defn ver-tope [pila] (first pila))