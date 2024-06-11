(ns tp2.pila)

(defn pila [tortuga] (conj '() tortuga))

(defn pila-desapilar[pila] (pop pila))

(defn pila-apilar[pila tortuga] (conj pila tortuga))

(defn pila-ver-tope [pila] (first pila))