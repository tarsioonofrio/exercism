(ns raindrops)

(defn modulo? [n, d] ;; <- arglist goes here
  ;; your code goes here
  (if (= 0 (mod n d)) true false))


(defn convert [n] ;; <- arglist goes here
      ;; your code goes here
  (let [s (str (if (modulo? n 3) "Pling") (if (modulo? n 5) "Plang") (if (modulo? n 7) "Plong"))]
    (if (= "" s) (str n) s))
  )
