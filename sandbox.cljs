(defn update [val]
   (swap! app-state (fn [current-state]
        (let [current-target (:current-target @app-state)
            current-val (get-in current-state [:values @current-target])]
             (update-in current-state [:values @current-target] (quote val))))))