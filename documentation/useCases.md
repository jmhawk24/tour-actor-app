# ADMIN USER use cases

## Setup (Weeks, Tour Actors, and Presenters)

### 1.0 Create new batch of `weeks` for a given year (if needed)

* User selects the year to generate weeks for, and clicks "GENERATE WEEKS"
* If weeks have already been generated, then this will not run and a message will inform the user of that
* Otherwise, it will assign weeks in the following manner:
  * the first SUNDAY of the selected year will become the `starting_at` attribute of Week 1
  * The following SATURDAY will be set to `ending_at` of Week one
  * The app will then repeat this cycle for every Sunday in the calendar year. The last `ending_at` value
    (for Week 52) should be in the following year.

* Each week will have the following attributes:
  * id: an internal identifier to avoid too much timestamp logic
  * starting_at: the first day of the week (will be Sunday)
  * ending_at: last day of the week
* Other parts of the system (namely `residencies` and `tour_buckets`)

### 1.1 Create `tour_actors`
Complete this step for any new tour actors.
Go to the "Tour Actors" view. (tour actors view should be basically the same as presenters view. 
  a List of TAD components on the left and an option to add a new one)
* Give each new `tour_actor` a name, phone, email

### 1.2 Create `presenters` for any first-time presenters

Go to "Presenters" view and select "+" box to add a new presenter.
Complete the following:
* give a "name" to presenter (e.g. Lolo School District)
* add city, state, and zip code
* in the future, users will be able to filter presenters by any of the above in the presenters list

## Create Tours!
Before creating tours, make sure you have already created any new Tour Actors and Presenters. Also make sure 
weeks have been generated for your new tour. 

### 2. Create `tour bucket` ("Tour Buckets" view)
_Tour bucket view could be the same as presenters and tour actors. A list of tour buckets ordered by created_at desc, labeled with names and start/end dates.
Click on a Tour Bucket and go to "Tour Bucket" view. This can be the same view: a list of team tours, and an option to create new ones
Finally, Team Tour View will be different, with all weeks listed and any assigned residencies._
System should already have generated `weeks`. If not, go back to step 0. 

* select starting week and ending week for new `tour_bucket`.
* give the new `tour_bucket` a name (e.g. "Winter/Spring 2023")

### 3. Create `team_tours`.
Start on the `tour_bucket` view, and select the `tour_bucket` to which you'd like to add `team_tours`
* Give the `team_tour` a name (aka "SEC-1")
* Assign `tour_actors` (Step 4 below)
* Assign to a `tour_bucket` (this determines which weeks are available to be filled with residencies) 
* Add `residencies` to each `week` of the `team_tour` (Step 5 below)
* Repeat for each additional `team_tour`

### 4. Assign `tour_actors` to a `team_tour`

User must be on the `team_tour` view to do this step.
* Select a `team_tour`. Under "Tour Actors", see a slot for TAD 1 and TAD 2
* for each TAD, click the dropdown to select the appropriate `tour_actor` based on first and last name.

### 5. Add `residencies` to a `team_tour`

User can access this step from either the `team_tour` page or the `residencies` page.

##### Add residencies from `team_tour` page
NOTE: the corresponding `presenter` MUST be created already

From `team_tours` page:
* choose a specific `team_tour` to update
* assign a `tour_bucket` if you haven't already (this will make `weeks` available for `residencies`)
* Locate the `week` to which you would like to add a `residency` and click "Add Residency". This leads user 
  to "Create Residency" view with `tour_bucket`, `team_tour`, and `week` pre-filled
* Either select an existing `residency` from the dropdown, or select "Create New Residency"

##### Create `residency` from "Add Residency" view
NOTE: the corresponding `presenter` and `tour_bucket` MUST be created already

User completes the following:
* select a `presenter`
  * can enter search bar to filter by presenter name
  * upon selection, UI should pre-populate details based on previous year
  * or, create new presenter
* `tour_bucket` (e.g. "Winter/Spring 2023") (required)
* `team_tour` (e.g. "SEC-1) (optional)
* select correct `week` from list of weeks in the `tour_bucket` (required)
* `presenter_contact`
  * box appears with pre-filled presenter_contact information. 
  * User can remove the prefilled presenter_contact with an X in the corner
  * User can select a box with a "+" to add a new. They can select from previous `contacts` for 
  that `presenter` or create a new `presenter_contact`


COMMENTS TO REMOVE:
so far the specs above seem to demand the following crud routes:
GET/POST weeks
GET/POST/PUT/DELETE tour actors
GET/POST/PUT/DELETE presenters
GET/POST/PUT/DELETE tour buckets
GET/POST/PUT/DELETE team tours
GET/POST/PUT/DELETE residencies
GET/POST/PUT/DELETE residency_images, tour_reports