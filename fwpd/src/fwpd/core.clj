(ns fwpd.core)

(def filename "suspects.csv")

(def vampire-keys [:name :glitter-index])

(defn str->int
  [string]
  (Integer. string))

(def conversions {:name identity :glitter-index str->int})

(defn convert
  [vamp-key value]
  ((get conversions vamp-key) value))

(defn parse
  "Convert a CSV into rows of columns"
  [string]
  (map #(clojure.string/split % #",")
       (clojure.string/split string #"\n")))

(defn mapify
  "Return a seq of maps like {:name \"Edward Cullen\" :glitter-index 10}"
  [rows]
  (map (fn [unmapped-row]
         (reduce (fn [row-map [vamp-key value]]
                   (assoc row-map vamp-key (convert vamp-key value)))
                 {}
                 (map vector vampire-keys unmapped-row)))
       rows))

(defn glitter-filter
  [minimum-glitter records]
  (filter #(>= (:glitter-index %) minimum-glitter) records))

(def suspects (mapify (parse (slurp filename))))

(glitter-filter 3 suspects)

; Chapter 4 Exercises

; 4.1
(map :name (glitter-filter 3 suspects))

; 4.2
(defn append
  [suspects info]
  (conj suspects (into {} (map vector vampire-keys info))))

(glitter-filter 4 (append suspects ["Katy Perry" 6]))
