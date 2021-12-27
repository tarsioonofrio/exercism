(ns elyses-destructured-enchantments)

(defn first-card
  "Returns the first card from deck."
  [deck]
  (first deck)
)

(defn second-card
  "Returns the second card from deck."
  [deck]
  (second deck)
)

(defn swap-top-two-cards
  "Returns the deck with first two items reversed."
  [deck]
  (assoc deck 0 (second deck) 1 (first deck))
)

(defn discard-top-card
  "Returns a vector containing the first card and
   a vector of the remaining cards in the deck."
  [deck]
  (let [remain (drop 1 deck)]
    (vector (first deck)
            (if
              (< 0
                 (count remain))
              remain nil)
            )
    )
)

(def face-cards
  ["jack" "queen" "king"])

(defn insert-face-cards
  "Returns the deck with face cards between its head and tail."
  [deck]
  (if
    (< 0 (count deck))
    (vec (concat (vector (first deck)) face-cards (drop 1 deck)))
    face-cards)
)
