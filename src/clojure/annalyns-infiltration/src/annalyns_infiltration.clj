(ns annalyns-infiltration)

(defn can-fast-attack?
  "Returns true if a fast-attack can be made, false otherwise."
  [knight-awake?]
  (not knight-awake?)
  )

(defn can-spy?
  "Returns true if the kidnappers can be spied upon, false otherwise."
  [knight-awake? archer-awake? prisoner-awake?]
  (not (nil? (some true? [knight-awake? archer-awake? prisoner-awake?])))
  )

(defn can-signal-prisoner?
  "Returns true if the prisoner can be signalled, false otherwise."
  [archer-awake? prisoner-awake?]
  (if (and (false? archer-awake?) (true? prisoner-awake?)) true false)
  )

(defn can-free-prisoner?
  "Returns true if prisoner can be freed, false otherwise."
  [knight-awake? archer-awake? prisoner-awake? dog-present?]
  (cond
    (and (true? dog-present?) (false? archer-awake?)) true
    (and (false? dog-present?) (true? prisoner-awake?) (false? archer-awake?) (false? knight-awake?)) true
    :default false
    )
  )
