(ns galacart-gallery.views
  (:require
    [re-frame.core :as re-frame]
    [galacart-gallery.subs :as subs]
    ))

;; home

(defn home-panel []
  (let [name (re-frame/subscribe [::subs/name])
        products (re-frame/subscribe [::subs/products])]
    [:div
     [:h1 (str "Welcome " @name)]

     [:div
      [:a {:href "#/about"}
       "go to About Page"]]
     [:ul
      (for [p (seq @products)]
        [:li
         [:div
          [:img {:src (:image p)}]
          (:description p)]
         ])]
     ]
    ))


;; about

(defn about-panel []
  [:div
   [:h1 "This is the About Page."]

   [:div
    [:a {:href "#/"}
     "go to Home Page"]]])


;; main

(defn- panels [panel-name]
  (case panel-name
    :home-panel [home-panel]
    :about-panel [about-panel]
    [:div]))

(defn show-panel [panel-name]
  [panels panel-name])

(defn main-panel []
  (let [active-panel (re-frame/subscribe [::subs/active-panel])]
    [show-panel @active-panel]))
