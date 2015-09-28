; this isn't executed, it's just for reference. special thanks to Chris LaRose (https://github.com/cjlarose/) for
; this snippet
; 
; basic idea: nest the value registers inside the atomic state variable, and maintain a "current-target" pointer
;             that returns the register currently in focus. this implements something close to the register-transfer
;             level abstraction typical of control unit architectures

(defn update [val]
   (swap! app-state (fn [current-state]
        (let [current-target (:current-target @app-state)
            current-val (get-in current-state [:values @current-target])]
             (update-in current-state [:values @current-target] (quote val))))))
