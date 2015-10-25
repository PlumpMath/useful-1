(ns useful.core
  (:use clojure.test))

(defn indexed
  "Returns a lazy sequence of [index, item] pairs, where items come
  from 's' and indexes count up from zero.
  (indexed '(a b c d))  =>  ([0 a] [1 b] [2 c] [3 d])"
  [s]
  (map vector (iterate inc 0) s))

(defn positions
  "Returns a lazy sequence containing the positions at which pred
   is true for items in coll."
  [pred coll]
  (for [[idx elt] (indexed coll) :when (pred elt)] idx))

; (positions #{99} [0 99 3334 53 2 5 99 2 55 63]) ->

(defn explode-to-digits [number]
  "explode-to-digits takes an integer and returns a sequence of it's individual digits"
  (map #(Character/getNumericValue %) (str number)))