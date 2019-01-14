(ns galacart-gallery.views
  (:require
    [re-frame.core :as re-frame]
    [galacart-gallery.subs :as subs]
    ))


;; home

(defn home-panel []
  (let [products (re-frame/subscribe [::subs/products])]
    [:div {:class "product-list-container"}
     (for [product (seq @products)]
       ^{:key product}       ;; metadata to avoid warning with iterator requiring a key
       [:div {:class "product-container"}
        [:img {:src (:image product)}]
        [:p {:dangerouslySetInnerHTML {:__html (:description product)}}]]
       )]
    ))


;; Contact

(defn contact-panel []
  [:div
   [:img {:src "img/smiley.jpg"}]
   [:p "Concha aka Galacart, la autora de Pinturas Mallorca"]
   ])


;; main

(defn- panels [panel-name]
  [:div
   [:h1 {:class "header-banner"} "Mallorca Paintings - Galacart Gallery"]
   [:div {:class "menu-and-products-container"}
    [:ul
     [:li [:a {:href "#/"} "Home"]]
     [:li [:a {:href "#/contact"} "Contact"]]
     ]
    (case panel-name
      :home-panel [home-panel]
      :contact-panel [contact-panel]
      [:div])
    ]
   ])


(defn show-panel [panel-name]
  [panels panel-name])

(defn main-panel []
  (let [active-panel (re-frame/subscribe [::subs/active-panel])]
    [show-panel @active-panel]))
