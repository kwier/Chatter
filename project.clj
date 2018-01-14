(defproject chatter "0.1.0-SNAPSHOT"
  :description "This is a web app that will display posted messages.  "
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.5.1"]
                 [ring/ring-defaults "0.2.1"]
                 [ring/ring-jetty-adapter "1.3.2"]
                 [hiccup "1.0.5"]
                 [hickory "0.5.4"]
                 [environ "1.0.0"]]
  :plugins [[lein-ring "0.9.7"]
            [lein-environ "1.0.0"]]
  :ring {:handler chatter.handler/app
          :init chatter.handler/init
        :destroy chatter.handler/destroy}
  :aot :all
  :main chatter.handler
  :profiles
  {:dev
     {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.0"]]}
  :production
  {:ring
  {:open-browser? false, :stacktraces? false, :auto-reload? false}
:env {production true}}}
:upberjar-name "chatter-standalone.jar")
