(ns clojure-noob.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "I'm a little teapot!"))

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
