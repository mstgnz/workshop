FROM python:3
ENV PYTHONUNBUFFERED 1
RUN mkdir /code
WORKDIR /code
COPY . .
RUN python -m pip install pip
RUN pip install -r requirements.txt 
CMD ["python", "server.py"]
