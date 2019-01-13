(ns galacart-gallery.core
  (:require
   [reagent.core :as reagent]
   [re-frame.core :as re-frame]
   [galacart-gallery.events :as events]
   [galacart-gallery.routes :as routes]
   [galacart-gallery.views :as views]
   [galacart-gallery.config :as config]
   ))


(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (routes/app-routes)
  (re-frame/dispatch-sync [::events/initialize-db])
  (dev-setup)
  (mount-root))
