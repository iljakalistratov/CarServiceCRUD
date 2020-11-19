# Build project
mvn package

# Start minikube
minikube start
minikube addons enable ingress
eval "$(minikube docker-env --shell=bash)"

# Build Docker images
cd ../../../../../
docker build -f ./deployment/Dockerfile-Angular -t angular .
docker build -f ./deployment/Dockerfile-Springboot -t springboot .

# Apply
kubectl delete -f ./deployment/kubernetes-postgres.yml
kubectl apply -f ./deployment/kubernetes-postgres.yml
kubectl delete -f ./deployment/kubernetes-springboot.yml
kubectl apply -f ./deployment/kubernetes-springboot.yml
kubectl delete -f ./deployment/kubernetes-angular.yml
kubectl apply -f ./deployment/kubernetes-angular.yml
kubectl delete -f ./deployment/kubernetes-ingress.yml
kubectl apply -f ./deployment/kubernetes-ingress.yml

# Setup Prometheus
kubectl apply -f ./prometheus-monitor.yml
helm repo add stable https://charts.helm.sh/stable
helm repo update
helm install prometheus-monitoring stable/prometheus-operator --namespace monitoring-ns


# Success message
URL=$(minikube service angular --url)

echo "--------------------------------------"
echo "Started successfully in ${SECONDS} sec"
echo "visit at: http://minikube/ or ${URL}"
echo "--------------------------------------"