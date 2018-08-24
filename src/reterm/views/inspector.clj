(ns reterm.views.inspector
  (:require
    [reterm.state :as state]))

(defonce last-key (atom nil))

(defn inspector-view
  [opts]
  [:div (merge {:position :absolute
                :width (get-in @state/state [:screen :width])
                :height (get-in @state/state [:screen :height])
                :on-keypress (fn [key _] (reset! last-key key))}
               opts)
   ;; cursor xy
   [:div {:bg :black
          :y (dec (get-in @state/state [:screen :height]))}
    ":x " (str (:x (state/cursor))) " "
    ":y " (str (:y (state/cursor))) " "
    ":last " (str @last-key)]])

