(ns galacart-gallery.subs
  (:require
   [re-frame.core :as re-frame]))

(re-frame/reg-sub
 ::products
 (fn [db]
   (:products db)))

(re-frame/reg-sub
 ::active-panel
 (fn [db _]
   (:active-panel db)))
