from django.db import models
from django import forms

class Expense(models.Model):
  expense_file = models.FileField(null = True, upload_to = "files/")


class UploadFileForm(forms.Form):
  file = forms.FileField()
