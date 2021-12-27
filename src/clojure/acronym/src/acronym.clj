(ns acronym)

(require '[clojure.string :as str])


(defn for_acronym [phrase]                                  ;; <- arglist goes here
  ;; your code goes here
  (for [x (map list (subs phrase 0 (- (count phrase) 1)) (subs phrase 1))
        :let [x0 (str (first x))
              x1 (str (second x))]
        ]
    (if
      (or (= " " x0) (= "-" x0) (and (= x1 (str/upper-case x1)) (some? (re-seq #"[a-zA-Z]" x1))))
      (str/upper-case x1)
      )
    )
  )


(defn acronym [phrase]                                      ;; <- arglist goes here
  ;; your code goes here
  (cond
    (true? (clojure.string/includes? phrase ":")) (first (str/split phrase #":"))
    (= "" phrase) ""
    :default (apply str (remove nil? (for_acronym (str " " phrase))))
    )
  )

