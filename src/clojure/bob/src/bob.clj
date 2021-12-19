(ns bob
  (:require [clojure.string :as str]))


(defn all-uppercase? [s]
  (if (nil? s)
    false
    (every? (fn [x] (Character/isUpperCase x)) s))
 )

(defn all-non-digit? [s]
  (if (nil? s)
    false
    (every? (fn [x] (false? (Character/isDigit x))) s))
  )


(defn _question? [s]
  (str/includes? s "?"))

(defn question? [s]
  (= "?" (str (last s))))

(defn response-for [s] ;; <- arglist goes here
  ;; your code goes here

  (let [s-trim (str/trim s)
        s-alphabetic (re-find #"[a-zA-Z]+" s)]
    (cond
      (= true (question? s-trim) (all-uppercase? s-alphabetic)) "Calm down, I know what I'm doing!"
      (= true (question? s-trim)) "Sure."
      (= true (all-uppercase? s-alphabetic)) "Whoa, chill out!"
      (= s-trim "") "Fine. Be that way!"
      :default "Whatever."
      )
    )
  )
