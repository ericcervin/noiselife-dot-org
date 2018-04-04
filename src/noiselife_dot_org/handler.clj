(ns noiselife-dot-org.handler
  (:require [liberator.core :refer [resource defresource]]
            [liberator.representation :refer [ring-response]]
            [ring.middleware.params :refer [wrap-params]]
            [compojure.core :refer [defroutes ANY GET OPTIONS]]
            [cljstache.core :refer [render]]
            [clj-time.core :as t]
            [noiselife_dot_org.representations.20180402 :refer [template-20180402]]
            [noiselife_dot_org.representations.20170225c :refer [template-20170225c]]))




(def not-found-template "<!DOCTYPE html><html lang=\"en\"><head><title>Error 404 Not Found</title></head><body>404 - Not Found</body></html>")

(defresource not-found [ctx]
  :available-media-types ["text/html"]
  :handle-ok (fn [ctx] (ring-response {:status 404 :body (render not-found-template)})))

(defresource root [ctx]
             :allowed-methods [:get :options]
             :available-media-types ["text/html"]
             :handle-ok (render template-20180402))


(defroutes app-routes
  (GET "/" [] root)
  (ANY "*" [_] not-found))  

(def app
  (wrap-params app-routes))
