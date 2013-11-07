Attribute VB_Name = "친욥1"
Sub 브2()
Attribute 브2.VB_ProcData.VB_Invoke_Func = " \n14"
'
' 브2 브
'
    Dim data_wb As Workbook
    Dim nsheet As Worksheet
    
    Set data_wb = Workbooks("api_citycode.xlsm")
    Set nsheet = data_wb.Sheets(2)
    
    Dim MaxRows As Long
    MaxRows = nsheet.UsedRange.Rows.Count
    
    For i = 2 To MaxRows
        Dim city As String
        city = nsheet.Cells(i, 1).Value
        nsheet.Cells(i, 4).Value = getAreaId(city)
    Next i
End Sub
Sub fill2()
    Dim data_wb As Workbook
    Dim nsheet As Worksheet
    Dim nRange As Range
    
    Set data_wb = Workbooks("api_citycode.xlsm")
    Set nsheet = data_wb.Sheets(2)
       
    Dim MaxRows As Long
    MaxRows = nsheet.UsedRange.Rows.Count
    
    For i = 343 To MaxRows
        Dim city As String
        city = nsheet.Cells(i, 1).Value
        nsheet.Cells(i, 4).Value = getAreaId2(city)
    Next i
End Sub
Function getAreaId2(name As String) As String
    Dim msheet As Worksheet
    Dim api_wb As Workbook
    
    Set api_wb = Workbooks("areaid_listv1.0.2 - Copy.xlsx")
    Set msheet = api_wb.Sheets(1)
    
    Dim MaxRows As Long
    MaxRows = msheet.UsedRange.Rows.Count
    
    For i = 2 To MaxRows
        Dim val As String
        val = msheet.Cells(i, 5).Value
        If name = val Then getAreaId2 = msheet.Cells(i, 1): Exit For
    Next i
End Function

Sub mysub()
    Dim msheet As Worksheet
    Dim api_wb As Workbook
    
    Set api_wb = Workbooks("areaid_listv1.0.2 - Copy.xlsx")
    Set msheet = api_wb.Sheets(1)
    MsgBox (msheet.Cells(1, 1).Value)
   
End Sub

Function getAreaId(name As String) As String

    Dim msheet As Worksheet
    Dim api_wb As Workbook
    
    Set api_wb = Workbooks("areaid_listv1.0.2 - Copy.xlsx")
    Set msheet = api_wb.Sheets(1)
    
    Dim MaxRows As Long
    MaxRows = msheet.UsedRange.Rows.Count
    
    For i = 2 To MaxRows
        Dim val As String
        val = msheet.Cells(i, 3).Value
        If name = val Then getAreaId = msheet.Cells(i, 1): Exit For
    Next i
    
End Function

