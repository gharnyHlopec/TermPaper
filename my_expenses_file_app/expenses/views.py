from django.shortcuts import render
from django.http import HttpResponse
from .models import Expense, UploadFileForm
from django.template import loader

def expenses(request):
  myexpenses = Expense.objects.all().values()
  template = loader.get_template('all_expenses.html')
  context = {
    'myexpenses': myexpenses,
  }
  return HttpResponse(template.render(context, request))

def details(request, id):
  myexpense = Expense.objects.get(id=id)
  template = loader.get_template('details.html')
  context = {
    'myexpense': myexpense,
  }
  return HttpResponse(template.render(context, request))


def upload_file(request):
  if request.method == 'POST':
    form = UploadFileForm(request.POST, request.FILES)
    file = request.FILES['file']
    expense = Expense.objects.create(expense_file = file) 
    expense.save()
    template = loader.get_template('all_expenses.html')
    myexpenses = Expense.objects.all().values()
    context = {
    'myexpenses': myexpenses,
    }
    return HttpResponse(template.render(context, request))
  else:
    form = UploadFileForm()
  return render(request, 'upload.html', {'form': form})