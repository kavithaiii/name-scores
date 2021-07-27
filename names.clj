;; This program uses names.txt 
;; execute this program at REPL prompt of clojure
;; copy this file and paste on REPL terminal

(defn sum [x] (reduce + x))

(defn find-char-value [name1]
  (def stringmap {"A" 1, "B" 2, "C" 3, "D" 4, "E" 5, "F" 6, "G" 7, "H" 8, "I" 9, "J" 10, "K" 11, "L" 12, "M" 13, "N" 14, "O" 15, "P" 16, "Q" 	17, "R" 18, "S" 19, "T" 20, "U" 21, "V" 22, "W" 23, "X" 24, "Y" 25, "Z" 26})
;; (def name1 "BETTY")
;; (println "name length: " (count name1))

  ;; (defn sum [x] (reduce + x))

  (def sum-of-char (sum
                    (loop [i 0
                           character-arr []]
                      (if (< i (count name1))
                        (let [val (stringmap (str (nth (seq (char-array name1)) i)))]
                          (recur (inc i) (conj character-arr val)))
                        character-arr))))
  (println "sum-of-char >>>" sum-of-char)
sum-of-char)


(defn read-names []
  (with-open [rdr (clojure.java.io/reader "names.txt")]
    (doseq [line (line-seq rdr)]
      (def us (clojure.string/replace line #"[\"]" ""))
   ;; (println us)
      (def us1 (clojure.string/split us #","))
   ;; (println us1)
   ;; (println  "sorted line >>>" (sort us1))
      (def sorted-names-list (sort us1))
      (println "count >>>" (count sorted-names-list))
      (def name-list-length (count sorted-names-list))
      (println "name list length " name-list-length)

      ;; (defn sum [x] (reduce + x))

      (def sum-of-names (sum
                         (loop [i 0
                                name-value-arr []]
                           (if (< i name-list-length)
                             (do
                               (def n1 (nth sorted-names-list i))
                             ;; (println ">>>>>" n1 " is at postion " i)
                               (def name-position-in-array (+ i 1))
			     ;; (println "npInArray add one to it >>>" name-position-in-array)
                               (def name-value (* (find-char-value n1) name-position-in-array))
                               (println "sum of each char in a name MULTIPLIED by name position in array >>> " name-value)
                               (recur (inc i) (conj name-value-arr name-value)))
                             	name-value-arr)
                   		 )
                  		)
	  )
    (println "final value - NAME SCORE >>>> " sum-of-names)
    )
  )
)
