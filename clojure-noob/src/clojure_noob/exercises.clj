(ns clojure-noob.exercises
  (:gen-class))

; 3.1
(str "Clap" " Hands")
(vector 1 2 3)
(list :a :b :c)
(hash-map :a 1 :b 2)
(hash-set 1 2 3 3)

; 3.2
(defn add-hundred
  "Add 100 to input"
  [x]
  (+ x 100))
(add-hundred 1)

; 3.3
(defn inc-maker
  "Make an incrementor"
  [n]
  #(+ % n))
(def inc9 (inc-maker 9))
(inc9 10)

; 3.4
(defn mapset
  "Map over a set"
  [f x]
  (set (map f x)))
(mapset inc [1 1 2 2])

; 3.5
(def asym-alien-parts
  [{:name "head" :size 3}
   {:name "left-eye" :size 1}
   {:name "left-ear" :size 1}
   {:name "mouth" :size 1}
   {:name "nose" :size 1}
   {:name "neck" :size 2}
   {:name "left-shoulder" :size 3}
   {:name "left-upper-arm" :size 3}
   {:name "chest" :size 10}
   {:name "back" :size 10}
   {:name "left-forearm" :size 3}
   {:name "abdomen" :size 6}
   {:name "left-kidney" :size 1}
   {:name "left-hand" :size 2}
   {:name "left-knee" :size 2}
   {:name "left-thigh" :size 4}
   {:name "left-lower-leg" :size 3}
   {:name "left-achilles" :size 1}
   {:name "left-foot" :size 2}])

(defn matching-part
  [part loc]
  {:name (clojure.string/replace (:name part) #"^left-" (str loc "-"))
   :size (:size part)})

(defn matching-alien-parts
  [part]
  (map #(matching-part part %)
       ["right" "top" "bottom-left" "bottom-right"]))

(defn symmetrize-body-parts
  "Expects a seq of maps that have :name and :size"
  [asym-body-parts]
  (reduce #(into %1 (set (into [%2] (matching-alien-parts %2))))
          [] asym-body-parts))

(symmetrize-body-parts asym-alien-parts)

; 3.6
; Uses asym-alien-parts and matching-part from 3.5.
(defn matching-n-parts
  [part part-names]
  (map #(matching-part part %) part-names))

(defn symmetrize-n-body-parts
  "Expects a seq of maps that have :name and :size"
  [asym-body-parts part-names]
  (reduce #(into %1 (set (into [%2] (matching-n-parts %2 part-names))))
          [] asym-body-parts))

(symmetrize-n-body-parts asym-alien-parts ["a" "b" "c"])

; Chapter 4 exercises are in the fwpd project.

; 5.1
(def attr #(comp % :attrs))
((attr :int) {:name "Link" :attrs {:int 10 :str 12 :dex 18}})
