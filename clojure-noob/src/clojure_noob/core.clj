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
