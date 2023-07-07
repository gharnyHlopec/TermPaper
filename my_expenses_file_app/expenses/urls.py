from django.urls import path, include
from . import views
from .views import upload_file
from django.conf import settings
from django.conf.urls.static import static

urlpatterns = [
    path('expenses/', views.expenses, name='expenses'),
    path('list/', upload_file, name = 'list'),
    path('expenses/details/<int:id>', views.details, name='details'),
] + static (settings.MEDIA_URL, document_root = settings.MEDIA_ROOT)