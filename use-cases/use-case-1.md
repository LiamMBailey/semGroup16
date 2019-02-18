# USE CASE: 1 As a product owner I want to produce a report of Languages so that I can produce a report of the popularity of a language.

## CHARACTERISTIC INFORMATION

### Goal in Context

As an *Product owner* I want to produce a report of Languages so that I can produce a report of the popularity of a language. 

### Scope

Group

### Level

Primary task.

### Preconditions

We know the language.  Database contains current language data.

### Success End Condition

A report is available for Product owner to hand in.

### Failed End Condition

No report is produced.

### Primary Actor

Product Owner.

### Trigger

A request for language information is set out for the team.

## MAIN SUCCESS SCENARIO

1. task request language information for a given country.
2. Product owner captures name of the language to get information for.
3. Product owner extracts current Langauage information of all countries of the given language.
4. Product owner provides report to Lab review.

## EXTENSIONS

3. **language does not exist**:
    1. Product owner informs team no language exists.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0