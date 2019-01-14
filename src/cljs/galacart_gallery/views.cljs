(ns galacart-gallery.views
  (:require
    [re-frame.core :as re-frame]
    [galacart-gallery.subs :as subs]
    ))

;; home

(defn home-panel []
  (let [products (re-frame/subscribe [::subs/products])]
    [:div
     [:h1 "Mallorca's Galacart Gallery"]
     [:div {:class "menu-and-products-container"}
      [:ul
       [:li [:a {:href "#/"} "Home"]]
       [:li [:a {:href "#/about"} "About"]]
       ]
      [:div {:class "product-list-container"}
       (for [product (seq @products)]
         [:div {:class "product-container"}
          [:img {:src (:image product)}]
          [:p {:dangerouslySetInnerHTML {:__html (:description product)}}]]
         )]
      ]
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
