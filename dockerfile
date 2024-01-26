# Use the official Nginx base image
FROM nginx
# Copy the custom Nginx configuration file to the container
COPY nginx.conf /etc/nginx/conf.d/default.conf
COPY reports /usr/share/reports
USER root
RUN chown -R nginx:nginx /usr/share/reports