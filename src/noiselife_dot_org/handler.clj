(ns noiselife-dot-org.handler
  (:require [liberator.core :refer [resource defresource]]
            [liberator.representation :refer [ring-response]]
            [ring.middleware.params :refer [wrap-params]]
            [compojure.core :refer [defroutes ANY GET OPTIONS]]
            [cljstache.core :refer [render]]
            [clj-time.core :as t]
            [noiselife_dot_org.representations.20170225c :refer [template-20170225c]]))


(defroutes app-routes
  (GET "/" [] (render template-20170225c)))  

(def app
  (wrap-params app-routes))
