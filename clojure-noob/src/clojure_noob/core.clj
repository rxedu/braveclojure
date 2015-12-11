(ns clojure-noob.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "I'm a little teapot!"))

; Chapter 3

(+ 1 2 3)

(str "I " "am " "brave.")

(if true
  "Puppies"
  "No Puppies")

(if false
  "Puppies"
  "No Puppies")

(if false
  "No Puppies")

(if true
  (do (println "Success!")
      "Puppies")
  (do (println "Failure!")
      "No Puppies"))

(when true
  (println "Success!")
  "Puppies")

(nil? 1)
(nil? nil?)

(if 0
  "Puppies")

(if nil
  "Puppies"
  "No Puppies")

(= 1 1)
(= nil nil)
(= 1 2)

(or false nil :puppies :kitties)
(or (= 0 1) (= "yes" "no"))
(or nil)

(and :kitties :puppies)
(and :puppies nil false)

(def tools-to-use
  ["vim", "zsh", "tmux", "git"])
tools-to-use

(defn error-message
  [severity]
  (str "Oh noes! "
       (if (= severity :cuddles)
         "Too many puppies!"
         "No puppies!")))

(error-message :cuddles)
(error-message :itsbad)

(hash-map :a 1 :b 2)
(get {:a 0 :b 1} :b)
(get {:a 0 :b 1} :c)
(get {:a 0 :b 1} :c "puppies")
(get-in {:a 0 :b {:c "puppies"}} [:b :c])
({:name "Razor"} :name)

(:a {:a 1 :b 2 :c 3})
(:d {:a 1 :b 2 :c 3} "Nope")

(get [3 2 1] 0)
(get [:a "b" 3] 1)
(vector 3 2 1)
(conj [1 2 3] 4)

'(1 2 3 4)
(nth '(:a :b :c) 0)
(nth '(:a :b :c) 2)
(list 1 "two" {3 4})
(conj '(1 2 3) 4)

#{"kurt vonnegut" 20 :ice 9}
(hash-set 1 1 2 2)
(conj #{:a :b} :b)
(set [3 3 3 4 4])
(contains? #{:a :b} :a)
(contains? #{:a :b} 3)
(contains? #{:a :b nil} nil)
(:a #{:a :b})
(get #{:a :b} :a)
(get #{:a nil} nil)
(get #{:a nil} :c)

(or + -)
((or + -) 1 2 3)
((and (= 1 1) +) 1 2 3)
((first [+ 0]) 1 2 3)

(inc 1.1)
(map inc [0 1 2 3])

(defn too-cute
  "Return a cheer for something cute"
  [thing]
  (str "That " thing "is too cute!"))

(too-cute "puppy")

(defn x-chop
  "Neochop"
  ([name chop]
   (str "Your " chop " chop inflicts pain on " name "."))
  ([name]
   (x-chop name "karate")))

(x-chop "Khan")
(x-chop "Khan" "slap")

(defn squee
  [thing]
  (str "SQUEE! It's a " thing))

(defn squeer
  [& things]
  (map squee things))

(squeer "Puppy" "Kitty")

(defn favorite-things
  [name & things]
  (str "My name is " name " and I like "
       (clojure.string/join ", " things)
       ", etc."))

(favorite-things "Lilly" "puppies" "kitties")

(defn x-first
  [[first-thing]]
  first-thing)

(x-first [1 2 3 4])

(defn x-choose
  [[first-thing second-thing & other-things]]
  (str first-thing ", " second-thing ", "
       (clojure.string/join ", " other-things)))

(x-choose ["this" "that" "the other" "the another"])

(defn x-find
  [{x :horz y :vert}]
  (println (str "(" x ", " y ")")))

(x-find {:horz 3 :vert -7})

(defn x-finder
  [{:keys [x y]}]
  (println (str "(" x ", " y ")")))

(x-finder {:x 4 :y -2})

(defn x-goer
  [{:keys [x y] :as coor}]
  (println (str "(" x ", " y ")"))
  (println coor))

(x-goer {:x 4 :y 2})

(map (fn [name] (str "Hey, " name))
     ["Dick" "Jane"])

(def three-er (fn [x] (* 3 x)))
(three-er 11)

(#(* % 3) 8)

(map #(str "Hey, " %)
     ["Dick" "Jane"])

(#(str %1 " and " %2) "this" "that")
(#(identity %&) 1 2 3 :yo)

(defn inc-maker
  "Make a custom incrementor"
  [inc-by]
  #(+ % inc-by))

(def inc42 (inc-maker 42))
(inc42 8)

(def x 0)
(let [x 1] x)
(let [x (inc x)] x)

(def puppy-list ["Pongo" "Corgi" "Husky"])
(let [[pongo & puppies] puppy-list]
  [pongo puppies])

(into [:b] (set [:a :a]))

(loop [itr 0]
  (println (str "Num " itr))
  (if (> itr 3)
    (println "Done")
    (recur (inc itr))))

; Chapter 4

(seq '(1 2 3))
(seq [1 2 3])
(seq #{1 2 3})
(seq {:a 1 :b 2})
(into {} (seq {:a 1 :b 2}))

(map str ["a" "b" "c"] ["d" "e" "f"])
(map + [1 2 3] [-3 2 1])

(def humans   [2.3 4.5 2.4 6.6 7.7])
(def critters [4.5 6.7 4.3 7.5 3.2])
(defn unify-diet [human critter] {:human human :critter critter})
(map unify-diet humans critters)

(def sum #(reduce + %))
(def avg #(/ (sum %) (count %)))
(defn stats [numbers] (map #(% numbers) [sum count avg]))
(stats [3 4 1])
(stats [3.2 44 53.1 3.11])

(def identities
  [{:alias "Batman" :real "Bruce Wayne"}
   {:alias "Spider-Man" :real "Peter Parker"}
   {:alias "Santa" :real "Your mom"}
   {:alias "Easter Bunny" :real "Your dad"}])

(map :real identities)

(reduce (fn [new-map [key val]]
          (assoc new-map key (inc val)))
        {}
        {:a 20 :b 30})

(reduce (fn [new-map [key val]]
          (if (> val 4)
            (assoc new-map key val)
            new-map))
        {}
        {:a 5 :b 2})

(take 3 [1 2 3 4 5])
(drop 3 [1 2 3 4 5])

(def food-journal
  [{:month 1 :day 1 :human 5.3 :critter 2.3}
   {:month 1 :day 2 :human 5.1 :critter 2.0}
   {:month 2 :day 1 :human 4.9 :critter 2.1}
   {:month 2 :day 2 :human 5.0 :critter 2.5}
   {:month 3 :day 1 :human 4.2 :critter 3.3}
   {:month 3 :day 2 :human 4.0 :critter 3.8}
   {:month 4 :day 1 :human 3.7 :critter 3.9}
   {:month 4 :day 2 :human 3.7 :critter 3.6}])

(take-while #(< (:month %) 3) food-journal)
(drop-while #(< (:month %) 3) food-journal)
(take-while #(< (:month %) 4) (drop-while #(< (:month %) 2) food-journal))
(filter #(< (:human %) 5) food-journal)
(filter #(< (:month %) 3) food-journal)
(some #(> (:critter %) 5) food-journal)
(some #(> (:critter %) 3) food-journal)
(some #(and (> (:critter %) 3) %) food-journal)

(sort [4 3 5 3 2])
(sort-by count ["aaa" "c" "cc"])
(concat [1 2] [3 4])

(concat (take 8 (repeat "na")) ["Batman!"])
(take 3 (repeatedly #(rand-int 10)))

(defn even-numbers
  ([] (even-numbers 0))
  ([n] (cons n (lazy-seq (even-numbers (+ n 2))))))
(take 10 (even-numbers))

(map identity {:a "b"})
(into {} (map identity {:a "b"}))
(into [] (map identity {:a "b"}))
(into [] (map identity [:a "b"]))
(into #{} (map identity [:a :b :a]))
(into {:a 1} [[:b 2]])
(into [:a] '(:b :c))
(into {:a 1} {:b 2})
(conj [0] 1 2 3 4 5)

(max 0 4 5 2)
(apply max [3 5 3 2 45 4 32])
(def add10 (partial + 10))
(add10 20)

(defn lousy-logger
  [log-level message]
  (condp = log-level
    :warn (clojure.string/lower-case message)
    :emergency (clojure.string/upper-case message)))

(def warn (partial lousy-logger :warn))
(warn "Puppies")
