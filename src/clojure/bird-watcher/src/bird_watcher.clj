(ns bird-watcher)

(def last-week
  [0 2 5 3 7 8 4])

(defn today [birds]
  (last birds))

(defn inc-bird [birds]
  (update birds (- (count birds) 1) inc))

(defn day-without-birds? [birds]
  (false? (nil? (some (fn [x] (= x 0)) birds))))

(defn n-days-count [birds n]
  (reduce + (take n birds)))

(defn busy-days [birds]
  (count (filter (fn [x] (>= x 5)) birds)))

(defn odd-week? [birds]
  (every? true?
    (list
      (apply = (map (fn [x] (get birds x)) (range 0 (count birds) 2)))
      (apply = (map (fn [x] (get birds x)) (range 1 (count birds) 2)))
      )
    )
  )

