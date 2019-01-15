(ns galacart-gallery.views
  (:require
    [re-frame.core :as re-frame]
    [galacart-gallery.subs :as subs]
    [galacart-gallery.events :as events]
    ))


;; Product image modal, hidden by default

(defn product-image-modal []
  (let [product-image-modal (re-frame/subscribe [::subs/product-image-modal])]
    [:div {:class "product-image-modal"
           :style {:display (if (:visible @product-image-modal) "block" "none")}}
     [:div
      [:span {:dangerouslySetInnerHTML {:__html "&times;"}
              :on-click #(re-frame/dispatch [::events/toggle-product-image-modal {:visible false}])}]     ;; cross symbol to close window
      [:img {:src (:image-path @product-image-modal)}]
      ]]))


;; Home

(defn home-panel []
  (let [products (re-frame/subscribe [::subs/products])]
    [:div {:class "product-list-container"}
     [product-image-modal]   ;; Render product image modal, hidden by default
     (for [product (seq @products)]
       ^{:key product}       ;; metadata to avoid warning with iterator requiring a key
       [:div {:class "product-container"}
        [:img {:src (:image product)
               :on-click #(re-frame/dispatch [::events/toggle-product-image-modal {:visible true
                                                                                   :image-path (:image product)}])
               }]
        [:p {:dangerouslySetInnerHTML {:__html (:description product)}}]]
       )]
    ))

;; Contact

(defn contact-panel []
  [:div
   [:img {:src "img/smiley.jpg"}]
   [:p "Concha aka Galacart, la autora de Pinturas Mallorca"]
   ])


;; Main

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
