(ns anagram
  (:require [clojure.string :as str]))

(defn _anagrams-for [word prospect-list]                    ;; <- arglist goes here
  ;; your code goes here
  (let [true-false (map
                     (fn [x] (= (into (hash-set) (str/split word #"")) (into (hash-set) (str/split x #""))))
                     prospect-list)]
    (filter true? true-false)
    )
  )


(defn uncapitalize [word]
  (if (= (str/lower-case word) word)
    word
    (str/lower-case word)
    )
  )

(defn process-word [word]
  (str/capitalize (str/join "" (sort (uncapitalize word))))
  )

(defn anagrams-for [word prospect-list]                     ;; <- arglist goes here
  ;; your code goes here
  (let [word-sort (process-word word)]
    (filter
      some?
      (map
        (fn [x]
          (cond
            (= (str/lower-case word) (str/lower-case x)) nil
            (= word-sort (process-word x)) x
            )
          )
        prospect-list)
      )
    )
  )

