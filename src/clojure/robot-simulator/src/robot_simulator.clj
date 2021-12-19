(ns robot-simulator)

(defn turn-right [direction] ;; <- arglist goes here
  ;; your code goes here
  (get {:north :east :east :south :south :west :west :north} direction)
)

(defn turn-left [direction] ;; <- arglist goes here
  ;; your code goes here
  (get {:north :west :west :south :south :east :east :north} direction)
)

(defn turn [step direction] ;; <- arglist goes here
  ;; your code goes here
  (cond
    (= "R" step) (turn-right direction)
    (= "L" step) (turn-left direction)
  )
)


(defn move-step [steps coordinates direction] ;; <- arglist goes here
  (let [step0 (str (get steps 0))
        subs-steps (subs steps 1)]
    (if (= "A" step0)
      (cond
        (= :north direction) (hash-map :steps subs-steps
                                       :coordinates (update coordinates :y + 1)
                                       :bearing direction)
        (= :east direction) (hash-map :steps subs-steps
                                      :coordinates (update coordinates :x + 1)
                                      :bearing direction)
        (= :south direction) (hash-map :steps subs-steps
                                       :coordinates (update coordinates :y - 1)
                                       :bearing direction)
        (= :west direction) (hash-map :steps subs-steps
                                      :coordinates (update coordinates :x - 1)
                                      :bearing direction)
        )
      (hash-map :steps subs-steps :coordinates coordinates :bearing (turn step0 direction))
    )
  )
)

(defn move [data] ;; <- arglist goes here
  ;; your code goes here
  (if (= 0 (count (:steps data))) (dissoc data :steps)
    (move (move-step (:steps data) (:coordinates data) (:bearing data)))
    )
)


(defn simulate [steps robot-position] ;; <- arglist goes here
  ;; your code goes here
  (move (assoc robot-position :steps steps))
)

(defn robot [coordinates bearing] ;; <- arglist goes here
      ;; your code goes here
  (hash-map  :coordinates coordinates :bearing bearing)
)

